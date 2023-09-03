import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class EarningDayTile extends StatelessWidget {
  EarningDayTile({@required this.date, this.earningDay});

  final String date;
  final double earningDay;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 10.0, vertical: 10.0),
      child: Row(
        children: <Widget>[
          Expanded(
            child: Text(
              '$date',
              style: TextStyle(
                  fontWeight: FontWeight.w700, fontSize: kTextSecondary),
            ),
          ),
          Text(
            earningDay == null ? '-' : '\$${earningDay.round()}',
            style: TextStyle(
                fontWeight: FontWeight.w700, fontSize: kTextSecondary),
          ),
        ],
      ),
    );
  }
}
