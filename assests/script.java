// Assignment code here
var generateBtn = document.querySelector("generate");

//initial prompt to enter length, numbers,
function generatePassword() {
  var userInput = window.prompt("How long would you like your password to be?")
  var passwordLength = parseInt(userInput)
  if (isNaN(passwordLength)) {
    window.alert("Please enter a number.")
    return
  } 

  if (passwordLength < 8 || passwordLength > 128) {
  window.alert("Password length must be between 8 and 128 characters")
  return
  } 
  var userwantsNumbers = window.confirm("Would you like to include numbers in your password?")
  var userwantsSymbols = window.confirm("Would you like to include symbols in your password?")
  var userwantsLowercase = window.confirm("Would you like to include lowercase letters in your password?")
  var userwantsUppercase = window.confirm("Would you like to include uppercase letters in your password?")
}

// Write password to the #password input
function writePassword() {
  var password = generatePassword();
  var passwordText = document.querySelector("#password");

  passwordText.value = password;

}

// Add event listener to generate button
generateBtn.addEventListener("click", writePassword);

