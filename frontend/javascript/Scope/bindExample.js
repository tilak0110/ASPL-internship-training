// bindExample.js
const dev = {
  name: "Tilak",
  say() {
    console.log(`I'm ${this.name}`);
  }
};

const speak = dev.say.bind(dev);
speak(); // I'm Tilak
