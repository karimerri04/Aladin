import 'package:aladin_driver_flutter/screens/available_screen.dart';
import 'package:aladin_driver_flutter/screens/earning_screen.dart';
import 'package:aladin_driver_flutter/screens/pending_screen.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class BottomNavigationScreen extends StatefulWidget {
  @override
  _BottomNavigationScreenState createState() => _BottomNavigationScreenState();
}

class _BottomNavigationScreenState extends State<BottomNavigationScreen> {
  int _selectedIndex = 0;
  static const TextStyle optionStyle =
      TextStyle(fontSize: 30, fontWeight: FontWeight.bold);
  static const List<Widget> _widgetOptions = <Widget>[
    AvailableScreen(),
    PendingScreen(),
    EarningScreen(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: _widgetOptions.elementAt(_selectedIndex),
      ),
      bottomNavigationBar: BottomNavigationBar(
        unselectedItemColor: Colors.grey,
        currentIndex: _selectedIndex,
        selectedItemColor: kColorBlue,
        onTap: _onItemTapped,
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.search),
            title: Text(
              'Available',
              style: TextStyle(fontWeight: FontWeight.w600),
            ),
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.access_time),
            title: Text(
              'Pending',
              style: TextStyle(fontWeight: FontWeight.w600),
            ),
          ),
//          BottomNavigationBarItem(
//            icon: Icon(Icons.attach_money),
//            title: Text(
//              'Earning',
//              style: TextStyle(fontWeight: FontWeight.w600),
//            ),
//          ),
        ],
      ),
    );
  }
}
