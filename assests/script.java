// Assignment code here
var generateBtn = document.querySelector("#generate");

//getting a random item from list
function randomInt(min, max) {
  if (!max) {
    max = min
    min = 0
  }
  var rand = Math.random()
  return Math.floor(min*(1 - rand) + rand*max)
}

function getRandomItem(list) {
  return list[randomInt(list.length)]
}

//initial prompt to enter length
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
  //confirmation if user wants numbers, symbols, lowercase or uppercase letters
  var userwantsNumbers = window.confirm("Would you like to include numbers in your password?")
  var userwantsSymbols = window.confirm("Would you like to include symbols in your password?")
  var userwantsLowercase = window.confirm("Would you like to include lowercase letters in your password?")
  var userwantsUppercase = window.confirm("Would you like to include uppercase letters in your password?")

  var numberList = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
  var symbolList = [" ", "!", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[", "]", "^", "_", "`", "{", "|", "}", "~"]
  var lowercaseList = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]
  var uppercaselist = []

  var optionsCart = []

  //written to create uppercase letters  
  for (var i = 0; i <lowercaseList.length; i++) {
    uppercaseList[i] = lowercaseList[i].toUpperCase()
  }
  
  if (userWantsNumbers === true) {
    optionsCart.push(numberList)
  }
  if (userWantsSymbols === true) {
    optionsCart.push(symbolList)
  }
  if (userWantsLowercase === true) {
    optionsCart.push(lowercaseList)
  }
  if (userWantsUppercase === true) {
    optionsCart.push(uppercaseList)
  }

  //if no options are chosen
  if (optionsCart.length === 0) {
    optionsCart.push(lowercaselist)
  }

  var generatedPassword = ""

  for (var i = 0; i < passwordLength; i++) {
    var randomList = getRandomItem(optionsCart)
    var randomChar = getRandomItem(randomList)
    generatedPassword += randomChar
  }

  console.log(generatedPassword)
  return generatedPassword

}

// Write password to the #password input
function writePassword() {
  var password = generatePassword();
  var passwordText = document.querySelector("#password");

  passwordText.value = password;

}

// Add event listener to generate button
generateBtn.addEventListener("click", writePassword);

