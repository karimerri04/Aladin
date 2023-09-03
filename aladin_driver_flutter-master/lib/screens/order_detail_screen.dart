import 'package:aladin_driver_flutter/components/itemOrderTile.dart';
import 'package:aladin_driver_flutter/models/order_class.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class OrderDetailScreen extends StatefulWidget {
  final String orderId;

  OrderDetailScreen({
    this.orderId,
  });

  @override
  _OrderDetailScreenState createState() => _OrderDetailScreenState();
}

class _OrderDetailScreenState extends State<OrderDetailScreen> {
  @override
  Widget build(BuildContext context) {
    final order = Orders()
        .orderList
        .firstWhere((order) => order.orderId == widget.orderId);

    final productList = order.productList;

    print(productList);

    return Scaffold(
      appBar: AppBar(
        title: Text('Order detail'),
      ),
      body: Container(
        child: SingleChildScrollView(
          child: Container(
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: <Widget>[
                Container(
                  child: Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Card(
                      elevation: 3.0,
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10.0)),
                      child: Padding(
                        padding: const EdgeInsets.all(15.0),
                        child: Container(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: <Widget>[
                              Row(
                                children: <Widget>[
                                  Text(
                                    'Store address:',
                                    softWrap: true,
                                    overflow: TextOverflow.ellipsis,
                                    style:
                                        TextStyle(fontWeight: FontWeight.w700),
                                  ),
                                  SizedBox(
                                    width: 5.0,
                                  ),
                                  Text(
                                    order.storeAddress,
                                    softWrap: true,
                                    overflow: TextOverflow.ellipsis,
                                    style: TextStyle(
                                        fontWeight: FontWeight.w600,
                                        fontStyle: FontStyle.italic),
                                  ),
                                ],
                              ),
                              SizedBox(
                                height: 5.0,
                              ),
                              Row(
                                children: <Widget>[
                                  Text(
                                    'Customer address:',
                                    softWrap: true,
                                    overflow: TextOverflow.ellipsis,
                                    style: TextStyle(
                                      fontWeight: FontWeight.w700,
                                    ),
                                  ),
                                  SizedBox(
                                    width: 5.0,
                                  ),
                                  Text(
                                    order.customerAddress,
                                    softWrap: true,
                                    overflow: TextOverflow.ellipsis,
                                    style: TextStyle(
                                        fontWeight: FontWeight.w600,
                                        fontStyle: FontStyle.italic),
                                  ),
                                ],
                              ),
                              SizedBox(
                                height: 5.0,
                              ),
                              Row(
                                children: <Widget>[
                                  Text(
                                    'Delivery Time:',
                                    softWrap: true,
                                    overflow: TextOverflow.ellipsis,
                                    style:
                                        TextStyle(fontWeight: FontWeight.w700),
                                  ),
                                  SizedBox(
                                    width: 5.0,
                                  ),
                                  Text(
                                    '${DateFormat('MMMMEEEEd').format(order.deliverTime)}, ${DateFormat('jm').format(order.deliverTime)}',
                                    softWrap: true,
                                    overflow: TextOverflow.ellipsis,
                                    style: TextStyle(
                                        fontWeight: FontWeight.w600,
                                        fontStyle: FontStyle.italic),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ),
                      ),
                    ),
                  ),
                ),
                Divider(),
                Container(
                  child: ListView.builder(
                    shrinkWrap: true,
                    physics: NeverScrollableScrollPhysics(),
                    itemCount: productList.length,
                    itemBuilder: (context, index) {
                      return ItemOrderTile(
                          productId: productList[index].productId,
                          image: productList[index].image,
                          format: productList[index].format,
                          brand: productList[index].brand,
                          price: productList[index].price,
                          quantity: productList[index].quantity,
                          title: productList[index].title,
                          upc: productList[index].upc);
                    },
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
