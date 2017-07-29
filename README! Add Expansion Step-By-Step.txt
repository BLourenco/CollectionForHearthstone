1. Create Set Icon in both colour and grey (#808080)
2. Import the 2 vector images: icon_set_<name>_grey, icon_set_<name>_color
3. Create a new drawable resource, icon_set_<NAME>_toggle.xml
4. Copy/paste from other set toggle, replace icons with the 2 above.
5. In the values\styles.xml file, add a new copy a new <style> element for the new set, using the toggle resource created above.
6. In activity_card_filter.xml, copy a new <LinearLayout> element to create a new button, giving it a new id, a reference to the created toggle style, and setting the text to the set acronym.
7. In EnumsHS.java, add the new set in the CardSet enum, increasing the ID#.
8. In CardFilterActivity.java, complete the following:
	a. Add a new toggle button reference in the Set ToggleButton array.
	b. Set if the new button should be enabled/disabled when Standard/Wild Only buttons are 		   pressed.
	c. Add a new "else if" for loading the state of the new filter.
	d. Update the calculatePresetToggleState() method.
	e. Update the getSelectedSetFilters() method.
9. Add color to colors.xml (Currently, set colors are unused, as the set icons are coloured when imported)
10. Add icon (and optionally, color) to ResourcesHS.java
