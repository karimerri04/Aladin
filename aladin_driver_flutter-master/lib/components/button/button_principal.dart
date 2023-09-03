import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class ButtonPrincipal extends StatelessWidget {
  ButtonPrincipal({@required this.color, @required this.text, this.onPressed});

  final Color color;
  final String text;
  final Function onPressed;

  @override
  Widget build(BuildContext context) {
    return RaisedButton(
      padding: EdgeInsets.all(14.0),
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(18.0),
      ),
      onPressed: onPressed,
      color: kColorBlue,
      textColor: Colors.white,
      child: Text(text.toUpperCase(), style: TextStyle(fontSize: kButton)),
    );
  }
}

class ButtonSecondary extends StatelessWidget {
  ButtonSecondary({this.color, @required this.text, this.onPressed});

  final Color color;
  final String text;
  final Function onPressed;

  @override
  Widget build(BuildContext context) {
    return RaisedButton(
      onPressed: onPressed,
      padding: EdgeInsets.all(14.0),
      disabledColor: kColorGrey,
      color: color,
      textColor: Colors.white,
      child: Text(text.toUpperCase(), style: TextStyle(fontSize: kButton)),
    );
  }
}
