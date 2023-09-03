import 'package:aladin_driver_flutter/components/button/button_facebook_google.dart';
import 'package:aladin_driver_flutter/components/button/button_principal.dart';
import 'package:aladin_driver_flutter/components/textField/textField_input_principal.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';
import 'package:flutter_datetime_picker/flutter_datetime_picker.dart';

class TellUsAboutYouScreen extends StatefulWidget {
  @override
  _TellUsAboutYouState createState() => _TellUsAboutYouState();
}

String birthday = 'Birthday';

class _TellUsAboutYouState extends State<TellUsAboutYouScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Tell us about you'),
      ),
      backgroundColor: kColorBlue,
      body: SafeArea(
        child: SingleChildScrollView(
          child: Container(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.stretch,
              //crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Padding(
                  padding: EdgeInsets.fromLTRB(20.0, 20.0, 20.0, 5.0),
                  child: Card(
                    shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(18.0)),
                    elevation: kElevation,
                    color: kColorWhite,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: <Widget>[
                        SizedBox(height: 30.0),
                        CircularCardWidget(
                          image: Icon(
                            Icons.person,
                            size: 60.0,
                            color: kColorBlue,
                          ),
                          onPressed: () {},
                        ),
                        SizedBox(height: 30.0),
                        Row(
                          children: <Widget>[
                            Expanded(
                              flex: 1,
                              child: Padding(
                                padding:
                                    EdgeInsets.fromLTRB(15.0, 8.0, 5.0, 8.0),
                                child: TextInput(
                                  hintText: 'First name',
                                  keyboardType: TextInputType.text,
                                  obscureText: false,
                                  colorBorder: kColorBlue,
                                  validator: (value) {},
                                  onChanged: (value) {},
                                ),
                              ),
                            ),
                            Expanded(
                              flex: 1,
                              child: Padding(
                                padding:
                                    EdgeInsets.fromLTRB(5.0, 8.0, 15.0, 8.0),
                                child: TextInput(
                                  hintText: 'Last name',
                                  keyboardType: TextInputType.text,
                                  obscureText: false,
                                  colorBorder: kColorBlue,
                                  validator: (value) {},
                                  onChanged: (value) {},
                                ),
                              ),
                            ),
                          ],
                        ),
                        Padding(
                          padding: EdgeInsets.symmetric(
                              horizontal: 15.0, vertical: 8.0),
                          child: TextInput(
                            hintText: 'Phone number',
                            keyboardType: TextInputType.phone,
                            maxLength: 14,
                            obscureText: false,
                            colorBorder: kColorBlue,
                            validator: (value) {},
                            onChanged: (value) {},
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.symmetric(
                              horizontal: 15.0, vertical: 8.0),
                          child: FlatButton(
                            onPressed: () {
                              DatePicker.showDatePicker(context,
                                  maxTime: DateTime.now(),
                                  currentTime: DateTime.now(),
                                  locale: LocaleType.en, onConfirm: (date) {
                                setState(() {
                                  birthday =
                                      '${date.year} - ${date.month} - ${date.day}';
                                  print(date);
                                });
                              });
                            },
                            child: Padding(
                              padding: const EdgeInsets.symmetric(
                                  horizontal: 5.0, vertical: 15.0),
                              child: Align(
                                alignment: Alignment.centerLeft,
                                child: Text(
                                  '$birthday',
                                  style: TextStyle(
                                      fontSize: kTextTitle,
                                      color: birthday != 'Birthday'
                                          ? kColorBlack
                                          : kColorGrey,
                                      fontWeight: FontWeight.w400),
                                ),
                              ),
                            ),
                            shape: RoundedRectangleBorder(
                              side: BorderSide(color: kColorBlue, width: 1.5),
                              borderRadius: BorderRadius.circular(32.0),
                            ),
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.all(15.0),
                          child: ButtonPrincipal(
                            onPressed: () {
                              Navigator.pushNamed(
                                  context, '/bottom_navigation_screen');
                            },
                            text: 'CONFIRM',
                            color: kColorBlue,
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
                Center(
                  child: Padding(
                    padding:
                        EdgeInsets.symmetric(horizontal: 20.0, vertical: 0.0),
                    child: GestureDetector(
                      onTap: () {
                        Navigator.pushNamed(context, '/terms_of_use_screen');
                      },
                      child: RichText(
                        textAlign: TextAlign.center,
                        text: TextSpan(
                            text: 'By signing up, you agree to our',
                            style: TextStyle(
                              color: kColorWhite,
                              fontSize: kTextLinks,
                            ),
                            children: <TextSpan>[
                              TextSpan(
                                text: ' Privacy Policy',
                                style: TextStyle(fontWeight: FontWeight.w700),
                              ),
                              TextSpan(
                                text: ' and',
                              ),
                              TextSpan(
                                text: ' Terms of Service',
                                style: TextStyle(fontWeight: FontWeight.w700),
                              )
                            ]),
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
