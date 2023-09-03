import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/material.dart';

class ItemDetailScreen extends StatelessWidget {
  final productId;
  final String title;
  final double price;
  final int quantity;
  final String image;
  final String brand;
  final int upc;
  final String format;

  ItemDetailScreen({
    @required this.productId,
    @required this.title,
    @required this.brand,
    @required this.price,
    @required this.quantity,
    @required this.image,
    @required this.upc,
    @required this.format,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('$title'),
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          child: Container(
            child: Padding(
              padding: const EdgeInsets.all(5.0),
              child: Stack(
                children: <Widget>[
                  Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Card(
                      elevation: 3.0,
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20.0)),
                      child: Padding(
                        padding: const EdgeInsets.symmetric(horizontal: 10.0),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.stretch,
                          mainAxisSize: MainAxisSize.min,
                          children: <Widget>[
                            Container(
                              width: 200.0,
                              height: 200.0,
                              child: Image(
                                image: AssetImage(image),
                              ),
                            ),
                            Divider(
                              height: 30.0,
                            ),
                            Row(
                              children: <Widget>[
                                Container(
                                  child: Column(
                                    crossAxisAlignment:
                                        CrossAxisAlignment.start,
                                    children: <Widget>[
                                      Text(
                                        '$brand',
                                        style: TextStyle(
                                            fontWeight: FontWeight.w700,
                                            color: Colors.grey[400],
                                            fontSize: 18.0),
                                      ),
                                      SizedBox(
                                        height: 5.0,
                                      ),
                                      Text(
                                        '$title',
                                        style: TextStyle(
                                            fontWeight: FontWeight.w800,
                                            color: Colors.black,
                                            fontSize: 20.0),
                                        overflow: TextOverflow.ellipsis,
                                        softWrap: true,
                                      ),
                                      SizedBox(
                                        height: 5.0,
                                      ),
                                      Text(
                                        '$format',
                                        style: TextStyle(
                                            fontWeight: FontWeight.w600,
                                            color: Colors.black,
                                            fontSize: 18.0),
                                        overflow: TextOverflow.ellipsis,
                                        softWrap: true,
                                      ),
                                    ],
                                  ),
                                )
                              ],
                            ),
                            Divider(
                              height: 30.0,
                            ),
                            Container(
                              child: Row(
                                children: <Widget>[
                                  Expanded(
                                    child: Text(
                                      'UPC',
                                      style: TextStyle(
                                          fontWeight: FontWeight.w800,
                                          fontSize: 20.0,
                                          color: kColorBlue),
                                    ),
                                  ),
                                  Card(
                                    elevation: 2.0,
                                    shape: RoundedRectangleBorder(
                                        borderRadius:
                                            BorderRadius.circular(30.0)),
                                    color: kColorBlue,
                                    child: Padding(
                                      padding: const EdgeInsets.symmetric(
                                          horizontal: 8.0, vertical: 3.0),
                                      child: Text(
                                        '$upc',
                                        style: TextStyle(
                                            color: kColorWhite,
                                            fontWeight: FontWeight.w600,
                                            fontSize: 20.0),
                                      ),
                                    ),
                                  )
                                ],
                              ),
                            ),
                            Divider(
                              height: 30.0,
                              color: Colors.white,
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),
                  Positioned(
                    child: Container(
                      margin: EdgeInsets.all(0.0),
                      width: 60.0,
                      height: 60.0,
                      child: Material(
                        color: kColorBlue,
                        elevation: 7.0,
                        shape: CircleBorder(),
                        child: Padding(
                          padding: const EdgeInsets.all(0.0),
                          child: Center(
                            child: Text(
                              '${quantity}x',
                              style: TextStyle(
                                  fontWeight: FontWeight.w700,
                                  color: kColorWhite,
                                  fontSize: 20),
                            ),
                          ),
                        ),
                      ),
                    ),
                  )
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
