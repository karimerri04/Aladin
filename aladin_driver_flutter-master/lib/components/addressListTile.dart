import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class AddressListTile extends StatelessWidget {
  AddressListTile({this.address});

  final String address;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {},
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 15.0, vertical: 15.0),
        child: Row(
          children: <Widget>[
            Icon(Icons.location_on, color: kColorBlack),
            SizedBox(width: 10.0),
            Expanded(
              child: Container(
                child: Text(
                  address,
                  overflow: TextOverflow.ellipsis,
                  maxLines: 1,
                  softWrap: true,
                  style: TextStyle(
                      fontSize: kTextSecondary, fontWeight: FontWeight.w600),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
