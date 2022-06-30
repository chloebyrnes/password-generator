// Assignment code here
var generateBtn = document.querySelector("generate");

//initial prompt
function generatePassword() {
  var userInput = window.prompt("How long would you like your password to be?")
  var passwordLength = parseInt(userInput)
  if (isNaN(passwordLength)) {
    window.alert("Please enter a number.")
  }
}

// Write password to the #password input
function writePassword() {
  var password = generatePassword();
  var passwordText = document.querySelector("#password");

  passwordText.value = password;

}

// Add event listener to generate button
generateBtn.addEventListener("click", writePassword);

