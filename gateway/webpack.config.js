const path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: './src/main/app/main.js',
    output: {
        path: path.resolve(__dirname, './src/main/resources/static/'),
        filename: 'bundle.js'
    },

    resolve: {
        extensions: ['.js', '.jsx'], //**Change
        modules: [
            'node_modules'
        ]
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