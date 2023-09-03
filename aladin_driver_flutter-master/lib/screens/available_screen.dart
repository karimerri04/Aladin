import 'package:aladin_driver_flutter/animation/slide_up.dart';
import 'package:aladin_driver_flutter/components/appBar.dart';
import 'package:aladin_driver_flutter/components/orderTileWidget.dart';
import 'package:aladin_driver_flutter/models/order_class.dart';
import 'package:aladin_driver_flutter/screens/account_screen.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class AvailableScreen extends StatefulWidget {
  const AvailableScreen({
    Key key,
  }) : super(key: key);

  @override
  _AvailableScreenState createState() => _AvailableScreenState();
}

class _AvailableScreenState extends State<AvailableScreen> {
  final orderList = Orders().filterOrderList(DeliveryStatus.waiting);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: TopBar(
        title: '300 boulevard St-charles',
        leading: IconButton(
          icon: Icon(Icons.account_circle),
          onPressed: () {
            Navigator.push(
              context,
              SlideUpRoute(
                page: AccountScreen(),
              ),
            );
          },
        ),
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
