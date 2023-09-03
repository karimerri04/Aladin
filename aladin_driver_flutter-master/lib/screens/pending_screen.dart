import 'package:aladin_driver_flutter/components/appBar.dart';
import 'package:aladin_driver_flutter/components/orderTileWidget.dart';
import 'package:aladin_driver_flutter/models/order_class.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/material.dart';

class PendingScreen extends StatefulWidget {
  const PendingScreen({
    Key key,
  }) : super(key: key);

  @override
  _PendingScreenState createState() => _PendingScreenState();
}

String dropDownValue = 'Most relevant';

class _PendingScreenState extends State<PendingScreen> {
  final orderList = Orders().filterOrderList(DeliveryStatus.pending);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: TopBar(
        title: 'Pending',
      ),
      body: Container(
        color: kColorBackground,
        child: ListView.builder(
          itemCount: orderList.length,
          itemBuilder: (context, index) {
            return OrderTileWidget(
              orderId: orderList[index].orderId,
              image: orderList[index].storeImage,
              address: orderList[index].storeAddress,
              totalProducts: orderList[index].productList.length,
              deliveryStatus: orderList[index].deliveryStatus,
              deliveryTime: orderList[index].deliverTime,
            );
          },
        ),
      ),
    );
  }
}
