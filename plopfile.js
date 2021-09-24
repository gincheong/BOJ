module.exports = function (plop) {
  /**
   * Node.js Solution Generator
   */
  plop.setGenerator('js', {
    description: 'Node.js Solution Generator',
    prompts: [
      {
        type: 'input',
        name: 'id',
        message: 'What is the problem Id',
        validate: function (value) {
          if (/.+/.test(value)) {
            return true
          }
          return 'Problem Id is required'
        },
      },
    ],
    actions: [
      {
        type: 'add',
        path: 'src/BOJ{{id}}/Main.js',
        templateFile: 'templates/Main.js.hbs',
      },
    ],
  })

  /**
   * Java Solution Generator
   */
  plop.setGenerator('java', {
    description: 'Java Solution Generator',
    prompts: [
      {
        type: 'input',
        name: 'id',
        message: 'What is the problem Id',
        validate: function (value) {
          if (/.+/.test(value)) {
            return true
          }
          return 'Problem Id is required'
        },
      },
    ],
    actions: [
      {
        type: 'add',
        path: 'src/BOJ{{id}}/Main.java',
        templateFile: 'templates/Main.java.hbs',
      },
    ],
  })
}
