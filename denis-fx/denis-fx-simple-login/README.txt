Login screen:

<groupId>com.jfoenix</groupId>
            <artifactId>jfoenix</artifactId>
            <version>8.0.1</version>
			
Add jFoenix to scene builder



1. AnchorPane - pref height and width
2. Add id to AnchorPane: 

3. Create CSS file. 
Add in code:
 scene.getStylesheets().add("/styles/Styles.css");
 
4. Add image to same folder as .css

5. Add Panel to AnchorPane.
In SceneBuilder put stule:
a) -fx-background-color: #ffff
b) add effect: DropShadow
- click on DropShadow and select color
c) add style (+): -fx-background-radius: 30px

d) put Label to Pane and set Font: size, color and style
e) put Label to Pane and set Font: size, color and style (for comments)
f) add textField
- Label Float - true
- Prompt Text: Username
- Focus coclor: pink
g) add passwordField
- Label Float - true
- Prompt Text: Password
- Focus coclor: pink

h) Add button:
Get Started

- -fx-background-color
- -fx-background-radius: 50px



---------------------------------------------------------------------------------
Video screen:

1. AnchorPane - pref height and width
2. Add id to AnchorPane: 
- MediaView: fit Width and height like AnchorPane
- add fx:id: mediaView
3. Add Controller class (left down. default is set)
set up vidoe player inside init
4. Add pane to AnchorPane
- set radius, effect and bg-color

5. Set unfocus\focus color to 0 (put UI to start)
 -fx-border-color: white

6. Add button:
put text fill to white, BOLD
- -fx-background-color
-fx-background-radius



------------------------------------------------------------------------------------
Portraite screen:
1. AnchorPane - pref height and width
2. Add id to AnchorPane: 
rootPane
3.Add Pane to Center; set background-color:  #ffff, radius
- Add dropshadow
4. Add Label:
-fx-background-color: #04c994
text fieel : white, bold, size

bg-radius: 60px 60px 0px 0px

5. Add ImageView
add Image to view (right side)

6. Add GridPane:
(2*2)
Add textfield and passwordfiled
Set focus\unfocus color: #52a83f


Add 2 ImageView to first column.
Set opacity value to 0.07


7. Add 2 buttons: signin, signup with type: RAISED

8. Add CSS to scenebuilder.
9. Add btn hover in css
10. Add rotation of image:
Inside controller
Create RotateTransition for image




------------------------------------------------------------------------------------
Slider screen:
1. AnchorPane - pref height and width
2. Add id to AnchorPane: 
rootPane
3.Add 4 Pane to Center (0,0,0,0 - in layout);
 set fx:id pane1, pane2, pane3, pane4
 
4. Add Pane (for buttons) - put padding in layout;
add dROPsHADOW, COLOR, radius

5. Add label, textfiled, password, put padding (in layout) 

6. Select all p1-p4 and put visible = false

View - Show sample to inkect@FXML items







------------------------------------------------------------------------------------
Dark screen:
1. AnchorPane - pref height and width
2. Add id to AnchorPane: 
rootPane
3. Add IMageView and Image
4. Add 2 labels with border-color and radius, another with description
WrapText - for label