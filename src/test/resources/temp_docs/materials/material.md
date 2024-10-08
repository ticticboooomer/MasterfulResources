```json
{
  "id": "test_ore",
  "name": "Test Ore",
  "color": 2572753,
  "forms": [
    {
      "type": "mwg:form/ore",
      "dropType": "gemlike",
      "dropOverride": "minecraft:diamond" // optional field - default uses generated item
    },
    {
      "type": "mwg:form/ingot",
      "rawItem": "mwg:raw_test_ore", // optional field - default: assumed from material id
      "canSmelt": true // optional field - default: true
    }
  ]
}
```