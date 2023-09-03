import 'package:aladin_driver_flutter/components/button/button_facebook_google.dart';
import 'package:aladin_driver_flutter/models/order_class.dart';
import 'package:aladin_driver_flutter/screens/order_detail_screen.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class OrderTileWidget extends StatelessWidget {
  const OrderTileWidget({
    Key key,
    this.orderId,
    this.image,
    this.address,
    this.deliveryTime,
    this.totalProducts,
    this.deliveryStatus,
  }) : super(key: key);

  final String orderId;
  final String image;
  final String address;
  final DateTime deliveryTime;
  final int totalProducts;
  final DeliveryStatus deliveryStatus;

  @override
  Widget build(BuildContext context) {
    String status;
    Color statusColor;
    void deliveryStatusToString() {
      if (deliveryStatus == DeliveryStatus.waiting) {
        status = 'waiting';
        statusColor = kColorRed;
      } else if (deliveryStatus == DeliveryStatus.pending) {
        status = 'pending';
        statusColor = Colors.yellow[700];
      } else if (deliveryStatus == DeliveryStatus.completed) {
        status = 'completed';
        statusColor = kColorGreen;
      }
    }

    deliveryStatusToString();

    return GestureDetector(
      onTap: () {
        Navigator.push(
          (context),
          MaterialPageRoute(
            builder: (context) => OrderDetailScreen(
              orderId: orderId,
            ),
          ),
        );
      },
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Stack(
          children: <Widget>[
            Card(
              elevation: 3.0,
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10.0)),
              margin: EdgeInsets.symmetric(vertical: 15.0, horizontal: 5.0),
              child: Row(
                children: <Widget>[
                  Padding(
                    padding: const EdgeInsets.symmetric(vertical: 8.0),
                    child: Container(
                      width: 100,
                      child: CircularCardWidget(
                        fillColor: Colors.grey[50],
                        image: Image(
                          image: AssetImage(image),
                          width: 40.0,
                          height: 40.0,
                        ),
                      ),
                    ),
                  ),
                  Expanded(
                    child: Container(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: <Widget>[
                          Text(
                            address,
                            softWrap: true,
                            overflow: TextOverflow.ellipsis,
                            style: TextStyle(fontWeight: FontWeight.w600),
                          ),
                          SizedBox(
                            height: 10.0,
                          ),
                          Text(
                            '${DateFormat('MMMMEEEEd').format(deliveryTime)}',
                            softWrap: true,
                            overflow: TextOverflow.ellipsis,
                            style: TextStyle(fontWeight: FontWeight.w600),
                          ),
                          Text(
                            '${DateFormat('jm').format(deliveryTime)}',
                            softWrap: true,
                            overflow: TextOverflow.ellipsis,
                            style: TextStyle(fontWeight: FontWeight.w600),
                          )
                        ],
                      ),
                    ),
                  ),
                  Container(
                    child: Card(
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10.0),
                      ),
                      color: kColorBlue,
                      child: Padding(
                        padding: const EdgeInsets.all(10.0),
                        child: Text(
                          '$totalProducts items',
                          style: TextStyle(
                              color: kColorWhite,
                              fontSize: 15.0,
                              fontWeight: FontWeight.w600),
                        ),
                      ),
                    ),
                  ),
                  SizedBox(
                    width: 10.0,
                  )
                ],
              ),
            ),
            Positioned(
              left: 5.0,
              child: Card(
                elevation: 5.0,
                shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(30.0)),
                color: statusColor,
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                      horizontal: 10.0, vertical: 5.0),
                  child: Text(
                    '$status',
                    style: TextStyle(
                        color: kColorWhite, fontWeight: FontWeight.w600),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
