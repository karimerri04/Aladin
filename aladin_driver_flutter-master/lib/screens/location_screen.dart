import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class LocationScreen extends StatefulWidget {
  @override
  _LocationScreenState createState() => _LocationScreenState();
}

class _LocationScreenState extends State<LocationScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Address'),
        actions: <Widget>[
          IconButton(
            icon: Icon(
              Icons.navigate_next,
              size: 40.0,
            ),
            onPressed: () {
              Navigator.pushNamed(context, '/signup_screen');
            },
          ),
        ],
      ),
      backgroundColor: kColorBlue,
      body: SafeArea(
        child: Column(
          children: <Widget>[
            TextField(
              autofocus: false,
              textAlign: TextAlign.start,
              keyboardType: TextInputType.text,
              style: TextStyle(fontSize: kTextTitle, color: Colors.black),
              decoration: InputDecoration(
                filled: true,
                border: InputBorder.none,
                prefixIcon: Icon(
                  Icons.search,
                  color: Colors.grey,
                ),
                fillColor: Colors.white,
                hintStyle: TextStyle(color: Colors.grey, fontSize: kTextTitle),
                hintText: 'Enter your location',
              ),
            ),
          ],
        ),
      ),
    );
  }
}
