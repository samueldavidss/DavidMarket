package com.example.samuel.davidmarket;

import com.example.samuel.davidmarket.Models.Products;

/**
 * Created by Samuel on 02-Feb-18.
 */

public interface ListernerProducts {

  void click (Products products, String name, String measure, int price);
}
