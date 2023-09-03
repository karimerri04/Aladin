import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class DialogLogOut {
  void showDialogLogOut(context, onPressed) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(kRadiusCard),
          ),
          title: Text(
            "Log out",
            style: TextStyle(color: Colors.red),
          ),
          content: Text("Are you sure you want to log out?"),
          actions: <Widget>[
            FlatButton(
              child: Text("No"),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
            FlatButton(child: Text("Yes"), onPressed: onPressed),
          ],
        );
      },
    );
  }
}
