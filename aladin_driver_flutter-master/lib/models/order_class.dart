import 'package:aladin_driver_flutter/models/product_class.dart';
import 'package:flutter/cupertino.dart';

enum DeliveryStatus { waiting, pending, completed }

class Order {
  final String orderId;
  final String customerId;
  final String storeId;
  final String storeImage;
  final String storeAddress;
  final DateTime deliverTime;
  final String customerAddress;
  final double totalAmount;
  final List<Product> productList;
  DeliveryStatus deliveryStatus;

  Order(
      {@required this.orderId,
      @required this.customerId,
      @required this.storeId,
      @required this.storeImage,
      @required this.storeAddress,
      @required this.deliverTime,
      @required this.customerAddress,
      @required this.totalAmount,
      @required this.productList,
      this.deliveryStatus = DeliveryStatus.waiting});
}

class Orders {
  List<Order> _orderList = [
    Order(
      orderId: 'asd19sda01203',
      customerId: '590',
      storeId: '23',
      storeAddress: '2340 Boulevard Rosemont',
      storeImage: 'assets/images/iga_logo.png',
      customerAddress: '600 boulevard Roberval Ouest',
      totalAmount: 30,
      deliverTime: DateTime.parse('2020-05-20 19:18:04Z'),
      deliveryStatus: DeliveryStatus.waiting,
      productList: [
        Product(
            productId: '8971278asd23jhkjh',
            image: 'assets/images/food/apple.jpg',
            format: '200g',
            brand: 'Great Value',
            title: 'Delicious apples',
            quantity: 1,
            price: 0.99,
            upc: 32434262667276),
        Product(
            productId: '8971sad9123jhkjh',
            image: 'assets/images/food/tomato.jpg',
            format: '50g',
            title: 'Tomatoes',
            brand: 'Farmer expert',
            quantity: 5,
            price: 2.99,
            upc: 9629867276),
        Product(
            productId: '897127w123jhkjh',
            image: 'assets/images/food/guava.jpg',
            format: '150g',
            title: 'Guava from Cuba',
            brand: 'Guavanito',
            quantity: 3,
            price: 5.99,
            upc: 23423462667276),
        Product(
            productId: '897127891sd23jhkjh',
            image: 'assets/images/food/kiwi.jpg',
            format: '30g',
            title: 'Kiwi',
            brand: 'Kiwissss',
            quantity: 12,
            price: 3.99,
            upc: 262626786276),
      ],
    ),
    Order(
      orderId: 'assasda35a01203',
      customerId: '190',
      storeId: '13',
      storeImage: 'assets/images/maxi_logo.png',
      storeAddress: '2925 Sherbrooke St E, Montreal',
      customerAddress: '300 Rue St-Charles',
      totalAmount: 30,
      deliverTime: DateTime.parse('2020-05-20 15:18:04Z'),
      deliveryStatus: DeliveryStatus.pending,
      productList: [
        Product(
            productId: '8971278asd23jhkjh',
            image: 'assets/images/food/apple.jpg',
            format: '200g',
            title: 'Delicious apples',
            brand: 'Great Value',
            quantity: 10,
            price: 0.99,
            upc: 2626334247276),
        Product(
            productId: '897127891sd23jhkjh',
            image: 'assets/images/food/kiwi.jpg',
            format: '30g',
            title: 'Kiwi',
            brand: 'Kiwissss',
            quantity: 4,
            price: 3.99,
            upc: 2626242342234276),
      ],
    )
  ];

  List<Order> get orderList {
    return _orderList;
  }

  List<Order> filterOrderList(DeliveryStatus deliveryStatus) {
    List<Order> orderListFiltered = [];

    for (var order in _orderList) {
      if (order.deliveryStatus == deliveryStatus) {
        orderListFiltered.add(order);
      }
    }

    return orderListFiltered;
  }
}
