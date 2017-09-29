package com.target.retailproduct.service;

import com.target.retailproduct.exception.RetailProductException;
import com.target.retailproduct.model.Price;
import com.target.retailproduct.model.CurrencyTypeEnum;
import com.target.retailproduct.model.Product;
import com.target.retailproduct.model.response.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${com.target.retail.prod.desc.prfx}")
    private String ProdDescApiPrefix;

    @Value("${com.target.retail.prod.desc.sufx}")
    private String ProdDescApiSuffix;

    @Autowired
    private MongoOperations mongoOperations;

    public Product getProductById(int id) throws RetailProductException {
        log.info("Processing id "+id);
        Product product = new Product();
        String description = getDesc(getApiUrl(id));
        product.setName(description);
        product.setId(id);
        product.setCurrentPrice(getPrice(id));
        return product;
    }

    public boolean updatePrice(int id,Price amt){
        Query query = new Query(where("id").is(id));
        Update update = new Update();
        update.set("value", amt.getValue());
        update.set("currencyCode", amt.getCurrencyCode().name());
        mongoOperations.upsert(query, update, Price.class);

        return true;
    }

    private String getApiUrl(int id){
        return ProdDescApiPrefix + id + ProdDescApiSuffix;
    }

    private String getDesc(String apiUrl) throws RetailProductException {
        String description;
        try{
            long start = System.currentTimeMillis();
            ProductResponse productResponse = restTemplate.getForObject(apiUrl, ProductResponse.class);
            log.debug("Time spent to retrieve description: "+ (System.currentTimeMillis() - start));

            description = productResponse.getProductCompositeResponse().
                    getItems().get(0).getOnlineDescription().getValue();
        }catch(RestClientException ex){
            throw new RetailProductException("Timed out getting description",ex);
        }catch(Exception ex){
            throw new RetailProductException("Could not get description. Possibly invalid product",ex);
        }

        return description;

    }

    private Price getPrice(int id) throws RetailProductException {
        try{
            long start = System.currentTimeMillis();
            Query query = new Query(where("id").is(id));
            Price price = mongoOperations.findOne(query, Price.class);
            if(price==null){
                price = new Price();
                price.setValue(-1);
                price.setCurrencyCode(CurrencyTypeEnum.valueOf("USD"));
            }

            log.debug("Time spent to update price: "+ (System.currentTimeMillis() - start));
            return price;
        }catch(DataAccessException dae){
            throw new RetailProductException("price (MongoDB) service is down",dae);
        }

    }

}
