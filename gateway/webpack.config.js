const path = require('path');
module.exports = {
    entry: './src/main/app/main.js',
    output: {
        path: path.resolve(__dirname, './src/main/resources/static/'),
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['', '.js'],
        root: path.join(__dirname, './src/main/app/')
    },
    devServer: {
        inline: true,
        contentBase: './src/main/app',
        port: 8100
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader'
            }
        ]
    }
}