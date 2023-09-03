import 'package:flutter/material.dart';

class CircularCardWidget extends StatelessWidget {
  CircularCardWidget(
      {this.image, this.onPressed, this.fillColor = Colors.white});

  final Widget image;
  final Function onPressed;
  final Color fillColor;

  @override
  Widget build(BuildContext context) {
    return RawMaterialButton(
      onPressed: onPressed,
      child: image,
      shape: CircleBorder(),
      elevation: 3.0,
      fillColor: fillColor,
      padding: EdgeInsets.all(15.0),
    );
  }
}
