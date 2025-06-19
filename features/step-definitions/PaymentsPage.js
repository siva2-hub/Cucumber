const { expect } = require("@playwright/test");
const { When, Then } = require("@cucumber/cucumber");
let newTab;
async function goToStoreFromPortal(elements, page) {
    const promise = await page.waitForEvent('popup');
    await elements.get_by_text('Shop Now').click();
    newTab = await promise;
    return newTab;
}
module.exports = { goToStoreFromPortal };