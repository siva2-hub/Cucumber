const { time } = require("console");

module.exports={
    default:{
        require:['features/step-definitions/*.js'],//'features/support/hooks.js'],
        format:['json:reports/cucumber_report.json','html:reports/cucumber_report.html'],
        dryRun: false,
    }
}