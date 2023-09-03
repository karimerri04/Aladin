import 'package:aladin_driver_flutter/screens/item_detail_screen.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ItemOrderTile extends StatelessWidget {
  ItemOrderTile(
      {@required this.productId,
      @required this.image,
      @required this.title,
      @required this.format,
      @required this.price,
      @required this.brand,
      @required this.quantity,
      @required this.upc});

  final String productId;
  final String image;
  final String title;
  final String brand;
  final String format;
  final double price;
  final int quantity;
  final int upc;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => ItemDetailScreen(
              productId: productId,
              image: image,
              title: title,
              format: format,
              brand: brand,
              quantity: quantity,
              price: price,
              upc: upc,
            ),
          ),
        );
      },
      child: Padding(
        padding: const EdgeInsets.all(5.0),
        child: Stack(
          children: <Widget>[
            Card(
              margin: EdgeInsets.all(10.0),
              elevation: kElevation,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(kRadiusCard),
              ),
              child: Padding(
                padding:
                    const EdgeInsets.symmetric(horizontal: 10.0, vertical: 5.0),
                child: Row(
                  children: <Widget>[
                    Padding(
                      padding: const EdgeInsets.all(10.0),
                      child: Container(
                        width: 70.0,
                        height: 70.0,
                        child: Image(
                          image: AssetImage(image),
                        ),
                      ),
                    ),
                    Expanded(
                      child: Align(
                        alignment: Alignment.centerLeft,
                        child: Column(
                          children: <Widget>[
                            Align(
                              alignment: Alignment.centerLeft,
                              child: Text(
                                title,
                                overflow: TextOverflow.ellipsis,
                                maxLines: 1,
                                softWrap: true,
                                style: TextStyle(
                                  fontWeight: FontWeight.w700,
                                ),
                              ),
                            ),
                            Align(
                              alignment: Alignment.centerLeft,
                              child: Text(
                                format,
                                maxLines: 1,
                                style: TextStyle(
                                    color: kColorGrey,
                                    fontWeight: FontWeight.w500),
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                    Container(
                      child: Material(
                        color: kColorBlue,
                        elevation: kElevation,
                        borderRadius: BorderRadius.circular(10.0),
                        child: Padding(
                          padding: const EdgeInsets.symmetric(
                              horizontal: 10.0, vertical: 25),
                          child: Text(
                            '\$$price',
                            style: TextStyle(
                                color: kColorWhite,
                                fontSize: kTextTitle,
                                fontWeight: FontWeight.w700),
                          ),
                        ),
                      ),
                    )
                  ],
                ),
              ),
            ),
            Container(
              margin: EdgeInsets.all(0.0),
              width: 35.0,
              height: 35.0,
              child: Material(
                color: kColorBlue,
                elevation: 7.0,
                shape: CircleBorder(),
                child: Padding(
                  padding: const EdgeInsets.all(0.0),
                  child: Center(
                    child: Text(
                      '$quantity',
                      style: TextStyle(
                          fontWeight: FontWeight.w700,
                          color: kColorWhite,
                          fontSize: kTextTitle),
                    ),
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
