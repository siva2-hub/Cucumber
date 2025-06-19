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
    }
}
module.exports = Objects;
// This class defines the objects used in the login page tests.