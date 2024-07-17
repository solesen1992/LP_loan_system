# LP loan system
An LP (vinyl records) loan system. A console system where the user can borrow LP records. Made in Java.

The project is based on an LP Lending case involving a garage sale where LP records are lent to friends. The system needs to track individual records, loan information, and the friends who borrow the LPs.

Is a part of a group project made in the fall of 2023.

# Documentation
# Architecture
An open three-layer architecture is used, with a UI layer, control layer and model layer. The UI layer consists of a text interface where user input is read and handled. Different TUI classes handle various system areas, such as LoanTUI handling loans. The control layer consists of various control classes that manage the system's logic, with access to read and edit the model layer. The model layer is responsible for storing information within the system, using classes representing various real and abstract objects that need to be managed. Container classes are used to store and retrieve data, functioning similarly to a database.

## Design Class Diagram
![designklassediagrammet](https://github.com/user-attachments/assets/74d1686b-8772-48d8-bd72-112656110dd4)

### TUI layer
TUI is the text user interface. At the top of the diagram is the MainMenu class, the entry point of the program. Running the program from MainMenu presents a main menu with different submenus (Loan Menu, LP Menu, Loan Management Menu) for the user to choose from. Only the loan management menu has been implemented. MainMenu uses the TextInput and TextOptions classes to handle text input from the user, which are utilized by all classes in the UI layer to some extent. The LoanTUI class manages the loan menu to create a new loan.

### Control layer
The UI layer sends messages to the control layer. In the control layer, there are three classes: FriendController, LPController, and LoanController. These classes contain the logic for how the system operates and are responsible for managing the program's complex functionalities. LoanController is primarily responsible for the logic in Use Case 1: Create Loan.

### Model Layer
The control layer sends messages to the model layer. The model layer has three container classes and four classes that store information about friends, LPs, copies of LPs, and various loans. Container classes store and persist the information entered by the user into the LP, Copy, Friend, and Loan classes.

# Code Decisions
We have chosen to store copies within their respective LPs rather than giving them their own container class. This decision was made because the copies are so closely linked to the LPs and are a composition of the LPs. This means that the copies contain information about the LP, and the LP contains information about the copies, as the copies need to know which LP they are a copy of. We believe this complexity is still worthwhile because of how closely tied the copies are to the LPs.

We have decided that the loan should have information about which friend has borrowed it, rather than the friend having information about which loans they have. This decision was made because we believe it is a higher priority for the loan to have all the information it needs.

The LPController is responsible for both copies and LPs. Since these are so closely linked, and the LPs contain a list of the copies, we decided to have one LPController instead of also having a CopyController.

## LoanTUI
<img width="500" alt="loanTUI" src="https://github.com/user-attachments/assets/e1a8a497-dade-4391-9124-10bf10b47731">

Here is a piece of code from LoanTUI, which handles creating a loan (createLoan). LoanTUI is responsible for handling user input and passing it to its LoanController. First, LoanTUI requests the user's loan period. Then, LoanTUI asks the LoanController to create a loan.

When creating a loan, the following happens: The user inputs the friend's phone number and the copy's serial number. This information is passed to the LoanController, which finds the specific friend and copy based on the input data and adds them to the loan. Finally, LoanTUI asks the LoanController to complete the loan, and then LoanTUI prints the loan information on the screen. The information printed includes the loan number, loan date, loan period, serial number, and loan status.

If there is a copy of the LP, the system will also print the title of this copy. In the final implementation, the loan will not be completed if a copy and a friend cannot be found. If the loan is not completed, the LoanController will return null, and the system will print: "The loan could not be completed, please try again."

## Testing
The project group creates unit tests to ensure that the code works as expected. In total, five unit tests were created for different classes and methods. Below are a few examples of unit tests with accompanying explanations.

### LoanControllerTest
<img width="500" alt="LoanControllerTest" src="https://github.com/user-attachments/assets/da908936-4ce0-4117-a762-9400790a5176">

Unit tests were created for the more complex methods. An example is found in LoanControllerTest, which tests our LoanController. Here we have two different tests that test the findAndAddFriendByPhone method in the LoanController. In both methods, a new friend is created, and this friend is added to our friendContainer. We then call the findAndAddFriendByPhone method, which finds a friend with the phone number provided as a parameter and adds the friend to the loan.

In the first method, we check if the friend in our loan is the same as the friend we added. In the example above, we added the friend Kasper with the phone number 51813828 to our friendContainer. We then ask the findAndAddFriendByPhone method in the LoanController to check if it can find Kasper based on the phone number.

In the second method, however, there is no friend with the phone number we are searching for. In the example above, we added the friend Sara with the phone number 24686420. We choose to ask the findAndAddFriendByPhone method to check a completely different phone number than Sara's. Therefore, we do not compare but instead expect it to return null. The tests provide the expected result.

### LPControllerTest
<img width="500" alt="LpControllerTest" src="https://github.com/user-attachments/assets/5069cefa-7f6a-4908-bc87-3e950144357a">

Another interesting test is shown above, which tests the findCopyBySerialNumber method to see if we can find the correct copy of an LP record using the serial number.

This test is in our LPControllerTest. We had several problems with this and reviewed the code with a supervisor without being able to find the issue. After creating our TryMe class, we managed to find the error. We had forgotten to add our copy to our LP. This is what we do here:

The reason it is important that the copy is added to the LP is that our method searches for copies through our LPs. The method will not be able to find any copies if they are not added to the LP's ArrayList.

Finally, we set findCopyBySerialNumber("123D") = copy. In other words, we compare our method's ability to find a copy by the serial number with the copy that contains the same serial number. These should be the same. We also get a checkmark, indicating that the test worked as expected.
