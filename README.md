#Day 9 : SharedPreferences in Android

## Key Methods and Explanation
- **`getSharedPreferences(String name, int mode)`**: Retrieves the shared preferences file.
- **`edit()`**: Creates an editor to modify the shared preferences.
- **`putString(String key, String value)`**: Stores a string value in the preferences.
- **`putInt(String key, int value)`**: Stores an integer value in the preferences.
- **`getString(String key, String defValue)`**: Retrieves a stored string value or a default value if not found.
- **`getInt(String key, int defValue)`**: Retrieves a stored integer value or a default value if not found.
- **`commit()`**: Saves changes synchronously and returns a boolean indicating success.
- **`apply()`**: Saves changes asynchronously without a return value.

---

# DatePicker Dialog in Android

## Key Methods and Explanation
- **`DatePickerDialog` constructor**: Initializes the dialog with a listener, year, month, and day.
- **`setOnDateSetListener(DatePickerDialog.OnDateSetListener listener)`**: Sets a listener to handle the selected date.
- **`show()`**: Displays the dialog.
- **`onDateSet(DatePicker view, int year, int month, int day)`**: Callback triggered when the user selects a date.

---

# TimePicker Dialog in Android

## Key Methods and Explanation
- **`TimePickerDialog` constructor**: Initializes the dialog with a listener, hour, minute, and time format (24-hour or AM/PM).
- **`setOnTimeSetListener(TimePickerDialog.OnTimeSetListener listener)`**: Sets a listener to handle the selected time.
- **`show()`**: Displays the dialog.
- **`onTimeSet(TimePicker view, int hourOfDay, int minute)`**: Callback triggered when the user selects a time.
