
// Define the objects used in the login page tests
// function inputUsername(page) { return page.getByRole('textbox', { name: 'Email' }); }
// function inputPassword(page) { return page.getByRole('textbox', { name: 'Password' }); }
// function inputPassword(page) { return page.getByRole('textbox', { name: 'Password' }); }
// function loginButton(page) { return page.getByRole('button', { name: 'Sign In' }); }
// function get_by_text(page, textValue) { return page.getByText(textValue); }
// function userProfilePortal(page) { return page.locator("//img[@alt='profile']"); }
// function storeSearch(page) { return page.getByRole('textbox', { name: 'search' }); }
// function searchText(page) { return page.locator("//*[text()='Searching...']"); }
// function searchedProdName(page) { return page.locator('//*[@id="search"]/div[1]/div[1]/div/div[2]/ul/li/a/div[2]/p[1]'); }
// module.exports = {
//     inputUsername,
//     inputPassword,
//     loginButton,
//     userProfilePortal,
//     storeSearch,
//     searchedProdName,
//     get_by_text,
//     searchText
// }
class Elements {
    inputUsername(page) { return page.getByRole('textbox', { name: 'Email' }); }
    inputPassword(page) { return page.getByRole('textbox', { name: 'Password' }); }
    inputPassword(page) { return page.getByRole('textbox', { name: 'Password' }); }
    loginButton(page) { return page.getByRole('button', { name: 'Sign In' }); }
    get_by_text(page, textValue) { return page.getByText(textValue); }
    userProfilePortal(page) { return page.locator("//img[@alt='profile']"); }
    storeSearch(page) { return page.getByRole('textbox', { name: 'search' }); }
    searchText(page) { return page.locator("//*[text()='Searching...']"); }
    searchedProdName(page) { return page.locator('//*[@id="search"]/div[1]/div[1]/div/div[2]/ul/li/a/div[2]/p[1]'); }
    addToCartButton(page) { return page.getByRole('button', { name: 'Add to Cart' }); }
    viewCartButton(page) { return page.getByRole('link', { name: 'View Cart ' }); }
    checkoutButton(page) { return page.getByRole('link', { name: 'Checkout' }); }
    enterPhoneNumber(page) { return page.getByRole('textbox', { name: 'Enter Phone Number' }); }
}
module.exports = Elements;
