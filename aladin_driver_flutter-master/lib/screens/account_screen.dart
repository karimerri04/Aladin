import 'package:aladin_driver_flutter/components/appBar.dart';
import 'package:aladin_driver_flutter/components/dialog/dialog_log_out.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:settings_ui/settings_ui.dart';

class AccountScreen extends StatefulWidget {
  @override
  _AccountScreenState createState() => _AccountScreenState();
}

bool switchValue = true;

bool valMonday = true;
bool valTuesday = false;

class _AccountScreenState extends State<AccountScreen> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Scaffold(
        backgroundColor: kColorBackground,
        appBar: TopBar(
          title: 'Account',
          leading: IconButton(
            icon: Icon(Icons.clear),
            onPressed: () {
              Navigator.pop(context);
            },
          ),
        ),
        body: SettingsList(
          sections: [
            SettingsSection(
              title: 'Common',
              tiles: [
                SettingsTile(
                  title: 'Profile',
                  subtitle: 'Name, email',
                  leading: Icon(Icons.account_circle),
                  onTap: () {
                    Navigator.pushNamed(context, '/item_detail_screen');
                  },
                ),
                SettingsTile(
                  title: 'Password',
                  subtitle: 'Reset password',
                  leading: Icon(Icons.lock),
                  onTap: () {
                    Navigator.pushNamed(context, '/forgot_password_screen');
                  },
                ),
              ],
            ),
            SettingsSection(
              title: 'Settings',
              tiles: [
                SettingsTile.switchTile(
                  title: 'Notification',
                  leading: Icon(Icons.notifications),
                  switchValue: switchValue,
                  onToggle: (bool value) {},
                ),
                SettingsTile(
                  title: 'Language',
                  subtitle: '',
                  leading: Icon(Icons.language),
                  onTap: () {
                    Navigator.pushNamed(context, '/language_screen');
                  },
                ),
              ],
            ),
            SettingsSection(
              title: 'Payment',
              tiles: [
                SettingsTile(
                  title: 'Payment methods',
                  subtitle: '',
                  leading: Icon(Icons.credit_card),
                  onTap: () {
                    Navigator.pushNamed(context, '/payment_method_screen');
                  },
                ),
              ],
            ),
            SettingsSection(
              title: 'Other',
              tiles: [
                SettingsTile(
                  title: 'FAQ',
                  subtitle: '',
                  leading: Icon(Icons.help),
                  onTap: () {
                    Navigator.pushNamed(context, '/faq_screen');
                  },
                ),
                SettingsTile(
                  title: 'Terms of use',
                  subtitle: '',
                  leading: Icon(Icons.gavel),
                  onTap: () {
                    Navigator.pushNamed(context, '/terms_of_use_screen');
                  },
                ),
                SettingsTile(
                  title: 'Log out',
                  subtitle: '',
                  leading: Icon(Icons.exit_to_app),
                  onTap: () {
                    setState(() {
                      DialogLogOut().showDialogLogOut(context, () {});
                    });
                  },
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
