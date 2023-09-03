import 'package:aladin_driver_flutter/components/earningDayTile.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class EarningScreen extends StatefulWidget {
  const EarningScreen({
    Key key,
  }) : super(key: key);

  @override
  _EarningScreenState createState() => _EarningScreenState();
}

class _EarningScreenState extends State<EarningScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Select delivery time'),
      ),
      backgroundColor: kColorBlue,
      body: SafeArea(
        child: Container(
          color: kColorBackground,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            //crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Expanded(
                child: Container(
                  child: SingleChildScrollView(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: <Widget>[
                        Container(
                          child: Padding(
                            padding: EdgeInsets.all(10.0),
                            child: Card(
                                shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(18.0),
                                ),
                                elevation: kElevation,
                                color: kColorWhite,
                                child: Padding(
                                  padding: const EdgeInsets.all(10.0),
                                  child: Row(
                                    children: <Widget>[
                                      Column(
                                        crossAxisAlignment:
                                            CrossAxisAlignment.start,
                                        children: <Widget>[
                                          Text(
                                            'Sept 1 - Sept 7',
                                            style: TextStyle(
                                                fontWeight: FontWeight.w800),
                                          ),
                                          SizedBox(height: 5.0),
                                          Text(
                                            '15 orders completed',
                                            style: TextStyle(
                                                fontWeight: FontWeight.w500),
                                          )
                                        ],
                                      ),
                                      Expanded(
                                        child: Align(
                                          alignment: Alignment.centerRight,
                                          child: Material(
                                            color: kColorGreen,
                                            elevation: kElevation,
                                            shape: RoundedRectangleBorder(
                                              borderRadius:
                                                  BorderRadius.circular(12.0),
                                            ),
                                            child: Container(
                                              child: Padding(
                                                padding:
                                                    const EdgeInsets.all(8.0),
                                                child: Text(
                                                  '\$360',
                                                  style: TextStyle(
                                                      color: kColorWhite,
                                                      fontWeight:
                                                          FontWeight.w700,
                                                      fontSize: 24.0),
                                                ),
                                              ),
                                            ),
                                          ),
                                        ),
                                      )
                                    ],
                                  ),
                                )),
                          ),
                        ),
                        Container(
                          child: Padding(
                            padding: EdgeInsets.all(10.0),
                            child: Card(
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(18.0),
                              ),
                              elevation: kElevation,
                              color: kColorWhite,
                              child: ListView(
                                physics: NeverScrollableScrollPhysics(),
                                shrinkWrap: true,
                                children: <Widget>[
                                  EarningDayTile(
                                    date: 'September 1 2019',
                                    earningDay: 76,
                                  ),
                                  EarningDayTile(
                                    date: 'September 2 2019',
                                  ),
                                ],
                              ),
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
