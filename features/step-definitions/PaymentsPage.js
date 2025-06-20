const { expect } = require("@playwright/test");

let elements, newTab;
async function goToStoreFromPortal(getElements, page) {
    elements = getElements;
    const pagePromise = page.waitForEvent('popup');
    await elements.get_by_text('Shop Now').click();
    newTab = await pagePromise;
    return newTab;
}
async function partsSearch(productName) {
    let searchText = await elements.searchText;
    let searchResult = false;
    await expect(searchText.first()).toBeVisible({ timeout: 30000 }); await expect(searchText.first()).toBeHidden({ timeout: 30000 });
    let search_prod_name = await elements.searchedProdName;
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

module.exports = { goToStoreFromPortal, partsSearch };