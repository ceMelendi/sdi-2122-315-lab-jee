package com.uniovi.sdi;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.util.LinkedList;
import java.util.List;

public class ProductsService {

    public List<Product> getProducts() {
        List<Product> products = new LinkedList<Product>();
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile("C:\\Users\\uo276077\\Desktop\\SDI\\bd\\bdProducts");
            List<Product> response = db.queryByExample(Product.class);
            // NO RETORNAR LA MISMA LISTA DE LA RESPUESTA
            products.addAll(response);
        } finally {
            db.close();
        }

        return products;
    }

    public void setNewProduct(Product newProduct) {
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile("C:\\Users\\uo276077\\Desktop\\SDI\\bd\\bdProducts");
            db.store(newProduct);
        } finally {
            db.close();
        }
    }
}
