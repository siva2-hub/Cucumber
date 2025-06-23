const { expect } = require("@playwright/test");
// const elements = require('./Objects.js');
const Elements = require("./Objects.js");
const objects = new Elements();

let elements, newTab;
async function goToStoreFromPortal(page) {
    const pagePromise = page.waitForEvent('popup');
    // await elements.get_by_text('Shop Now').click();
    await objects.get_by_text(page, 'Shop Now').click();
    newTab = await pagePromise;
    return newTab;
}
async function partsSearch(page, productName) {
    let searchText = await objects.searchText(page);
    let searchResult = false;
    await expect(searchText.first()).toBeVisible({ timeout: 30000 }); await expect(searchText.first()).toBeHidden({ timeout: 30000 });
    let search_prod_name = await objects.searchedProdName(page);
    console.log('prods count at search is: ' + await search_prod_name.count())
    for (let index = 0; index < await search_prod_name.count(); index++) {
        const dis_prod_name = await search_prod_name.nth(index).textContent();
        if (dis_prod_name == productName) {
            await search_prod_name.nth(index).click(); searchResult = true; break;
        } else {
            searchResult = false;
        }
    }
    if (searchResult) { } else {
        throw new Error("getting error while search or item not found");
    }
}
async function addPartToCart(newTab) {
    await objects.addToCartButton(newTab).click();
    await expect(objects.viewCartButton(newTab)).toBeVisible({ timeout: 30000 }); // Adjust this line as needed to check for a specific element after adding to cart
    await objects.viewCartButton(newTab).click();
}
async function validateCustDetails(phone) {
    await objects.enterPhoneNumber(newTab).fill(phone);
    await objects.nextButton(newTab).click();
}
async function validateShippingDetails(shipMethodName) {
    let shipToName = objects.shipToNameField(newTab);
    if (await shipToName.getAttribute('value') == '') { await shipToName.fill('Test Ship to Name'); }
    await objects.shippingMethod(newTab).click();
    await objects.selectShippingMethod(newTab, shipMethodName).click();
    await objects.nextButton(newTab).click();
}
module.exports = { goToStoreFromPortal, partsSearch, addPartToCart, validateCustDetails, validateShippingDetails };