
  let a = 5, b = 9;

  a = a ^ b;
  b = a ^ b;
  a = a ^ b;

  console.log(`a: ${a}, b: ${b}`); // a: 9, b: 5

