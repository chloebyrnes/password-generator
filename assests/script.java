// Assignment code here
// Constant variables
const specialCharacters = [" ", "!", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "^", "_", "`", "~"];
const acceptableAnswers = ['yes', 'Yes', 'YES', 'no', 'No', 'NO'];
const numberCharacters = ['1','2','3','4','5','6','7','8','9','0'];
const upperCasedCharacters = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
const lowerCasedCharacters = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];

//Function to generate password--add variables
function generatePassword() {
var addSpecialCharacters; true;
var password = '';
var randomCharacter = true;
var passwordLength = 8;
var addUpperCase = true;
var addLowerCase = true;
var addNumbers = true;

//length data
passwordLength = getPasswordLength();

//uppercase data
addUpperCase = userPreference('upper case');
if(addUpperCase) {
  password += returnUpperCasedCharacter(generateNumber(upperCasedCharacters.length));
  passwordLength -= 1;
}

//lowercase data
addLowerCase = userPreference('lower case');
if(addLowerCase) {
  password += returnLowerCasedCharacter(generateNumber(lowerCasedCharacters.length))
  passwordLength -= 1;
}

//numbers data
addNumbers = userPreference('number');
if(addNumbers) {
  password += generateNumber (10);
  passwordLength -= 1;
}

//specialcharacters data
addSpecialCharacters = userPreference('special');
if(addSpecialCharacters) {
  password += returnSpecialCharacter (generateNumber(specialCharacters.length));
  passwordLength -= 1;
}

//error
if(!addUpperCase && !addLowerCase && !addNumbers &&!addSpecialChars) {
  return "Try again.";
}

//generate password by adding the number of remaining characters to the password string
for(var i = 0; i < passwordLength; i++) {
  randomCharacter = generateNumber(4) + 1;
  switch(randomCharacter) {
    case 1:
      if(addUpperCase) {
        password += returnUpperCasedCharacter(generateNumber(upperCasedCharacters.length));
      } else if(addLowerCase) {
          password += returnLowerCasedCharacter(generateNumber(lowerCasedCharacters.length));
      } else if(addNumbers) {
          password += generateNumber(10);
      } else {
          password += returnSpecialCharacter(generateNumber(specialCharacters.length));
      }
      break;
    case 2:
      if(addLowerCase) {
        password += returnLowerCasedCharacter(generateNumber(lowerCasedCharacters.length));
      } else if(addNumbers) {
          password += generateNumber(10);
      } else if(addSpecialChars) {
          password += returnSpecialCharacter(generateNumber(specialCharacters.length));
      } else {
          password += returnUpperCasedCharacter(generateNumber(upperCasedCharacters.length));
      }
      break;
    case 3:
      if(addNumbers) {
        password += generateNumber(10);
      } else if(addSpecialChars) {
          password += returnSpecialCharacter(generateNumber(specialCharacters.length));
      } else if(addUpperCase) {
          password += returnUpperCasedCharacter(generateNumber(upperCasedCharacters.length));
      } else {
        password += returnLowerCasedCharacter(generateNumber(lowerCasedCharacters.length));
      }
      break;
    default:
      if(addSpecialChars) {
        password += returnSpecialCharacter(generateNumber(specialCharacters.length));
      } else if(addUpperCase) {
          password += returnUpperCasedCharacter(generateNumber(upperCasedCharacters.length));
      } else if(addLowerCase) {
        password += returnLowerCasedCharacter(generateNumber(lowerCasedCharacters.length));
      } else {
          password += generateNumber(10);
      }
  }
}

//function continue prompting until valid entry
function userPreference(currentChoice) {
  var answer = window.prompt('Would you like ' + currentChoice + ' characters in the password (please enter "Yes" or "No")?');
  if(!acceptableAnswer(answer)) {
    window.alert('Please enter either "Yes" or "No" as your asnswer.');
    userPreference(currentChoice);
  } else {
    if(answer == 'no' || answer == 'No' || answer == 'NO' ) {
      return false;
    } else {
      return true;
    }
  }
}

  //Returns the boolean value of the user's choice
  function acceptableAnswer(answer) {
    for(var i = 0; i < acceptableAnswers.length; i++) {
      if(answer === acceptableAnswers[i]){
        return true;
      }
    }
    return false;
  }

//Each of these functions return a character from their respective strings. 
function generateNumber(max) {
  return Math.floor(Math.random() * max);
}

function returnUpperCasedCharacter(index) {
  return upperCasedCharacters.charAt(index);
}

function returnLowerCasedCharacter(index) {
  return lowerCasedCharacters.charAt(index);
}

function returnSpecialCharacter(index) {
  return specialCharacters.charAt(index);
}

//A function that scrambles the characters in the password (converts the string to a char array, and then reconstructs it before returning). 
function scramblePassword(password) {
  password = password.split('');
  var length = password.length;
  var tempChar = '';
  var randomNumber = null;

  for(var i = 0; i < length; i++) {
    randomNumber = generateNumber(length);
    tempChar = password[i];
    password[i] = password[randomNumber];
    password[randomNumber] = tempChar;
  }

  return password.join('');
}

return scramblePassword(password);
}


// Get references to the #generate element
var generateBtn = document.querySelector("#generate");

// Write password to the #password input
function writePassword() {
  var password = generatePassword();
  var passwordText = document.querySelector("#password");

  passwordText.value = password;

}

// Add event listener to generate button
generateBtn.addEventListener("click", writePassword);

