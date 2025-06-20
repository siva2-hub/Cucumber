class Objects {
    constructor(page) {
        this.page = page;
        // Define the objects used in the login page tests
        this.inputUsername = this.page.getByRole('textbox', { name: 'Email' });
        this.inputPassword = this.page.getByRole('textbox', { name: 'Password' });
        this.loginButton = this.page.getByRole('button', { name: 'Sign In' });
        this.get_by_text = (textValue) => { return this.page.getByText(textValue); }
        this.userProfilePortal = this.page.locator("//img[@alt='profile']");
        this.storeSearch = this.page.getByRole('textbox', { name: 'search' });
        this.searchText = this.page.locator("//*[text()='Searching...']");
        this.searchedProdName =  this.page.locator('//*[@id="search"]/div[1]/div[1]/div/div[2]/ul/li/a/div[2]/p[1]');
    }
}
module.exports = Objects;
// This class defines the objects used in the login page tests.