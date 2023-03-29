package com.mercadona.laProveta.model;

import com.mercadona.laProveta.model.Product;
import com.mercadona.laProveta.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final ProductRepository repository;

    public DatabaseLoader(ProductRepository yourRepository) {
        this.repository = yourRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        String[] names = {"Longanizas", "Pechuguetas", "Garbanzos", "Cebollas", "Cervezas"};
        String[] ids = {"12345678904234","12345678912345","12345678900987","12345678909876", "12345678904567"};
        for(int i=0;i<5;i++){
            Product product = new Product();
            product.setId(ids[i]);
            product.setName(names[i]);
            repository.save(product);
        }
    }
}
