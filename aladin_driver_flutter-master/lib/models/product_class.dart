import 'package:flutter/cupertino.dart';

class Product {
  final productId;
  final String title;
  final double price;
  final int quantity;
  final String image;
  final String brand;
  final int upc;
  final String format;
  bool isFound;

  Product(
      {@required this.productId,
      @required this.title,
      @required this.price,
      @required this.quantity,
      @required this.image,
      @required this.upc,
      @required this.brand,
      @required this.format,
      this.isFound = false});
}
