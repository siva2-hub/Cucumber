const { Given, When, Then, BeforeAll, AfterAll, setDefaultTimeout } = require("@cucumber/cucumber");
const playwright = require('@playwright/test');
const { expect } = require('@playwright/test');
const Objects = require('./Objects.js');
const { goToStoreFromPortal } = require("./PaymentsPage.js");
let browser, context, page, newTab, elements, newTabElements;
setDefaultTimeout(600000000); // 60 seconds
BeforeAll(async function () {
    browser = await playwright.chromium.launch({
        slowMo: 1000,
        headless: false, // Set to true for headless mode
        args: ['--start-maximized'],
    });
    context = await browser.newContext({ viewport: null });
    page = await context.newPage();
    elements = new Objects(page);
});
AfterAll(async function () {
    await page.close();
});
Given('I am on the login page with the URL {string}', async function (url) {
    await page.goto(url);
});
When('I enter my username as {string}', async function (username) {
    await elements.inputUsername.fill(username);
});
When('I enter my password as {string}', async function (password) {
    await elements.inputPassword.fill(password);
});
When('I click the login button', async function () {
    await elements.loginButton.click();
});
Then('I should see a welcome message {string}', async function (customerName) {
    await expect(elements.get_by_text(customerName)).toBeVisible({ timeout: 60000 });
});
Then('I should be redirected to the dashboard', async function () {
    await expect(elements.get_by_text('Dashboard')).toBeVisible({ timeout: 30000 });
});
Then('I should see an error message {string}', async function (error_message) {
    await expect(elements.get_by_text(error_message)).toBeVisible({ timeout: 30000 });
});
When('I log out', async function () {
    await elements.userProfilePortal.click();
    // await elements.get_by_text('Log Out').click();
    await page.waitForTimeout(2000); // Wait for logout to complete
});
Then('I should be redirected to the login page', async function () {
    // await expect(elements.inputPassword).toBeVisible({ timeout: 30000 });
});
Then('I should see an error message {string}, {string}', async function (error_message1, error_message2) {
    await expect(elements.get_by_text(error_message1)).toBeVisible({ timeout: 30000 });
    await expect(elements.get_by_text(error_message2)).toBeVisible({ timeout: 30000 });
});
When('I click on the Shop now button', async function () {
    newTab = await goToStoreFromPortal(elements, page);
});
Then('I should be redirected to the store home page', async function () {
    newTabElements = new Objects(newTab);
    await expect(newTabElements.get_by_text('Featured Products')).toBeVisible({ timeout: 50000 });
});
When('I search for a product with the name {string}', async function (string) {
    await newTabElements.storeSearch.fill(string);
});
When('I go to the product page', async function () {

});
When('I add the product to the cart', async function () {

});
When('I proceed to checkout', async function () {

});