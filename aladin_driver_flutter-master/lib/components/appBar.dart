import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/material.dart';

class TopBar extends StatelessWidget implements PreferredSizeWidget {
  TopBar({this.title, this.bottom, this.leading, this.onTap, this.actions});

  final String title;
  final Widget bottom;
  final List<Widget> actions;
  final Widget leading;
  final Function onTap;

  @override
  Size get preferredSize => Size.fromHeight(56.0);

  @override
  Widget build(BuildContext context) {
    return Stack(children: [
      AppBar(
        automaticallyImplyLeading: false,
        backgroundColor: kColorBlue,
        title: GestureDetector(
          child: Text(title),
          onTap: onTap,
        ),
        actions: actions,
        bottom: bottom,
        leading: leading,
      ),
    ]);
  }
}
