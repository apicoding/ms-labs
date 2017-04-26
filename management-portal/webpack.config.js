const path = require('path');
var webpack = require('webpack');
var combineLoaders = require('webpack-combine-loaders');
var HtmlWebpackPlugin = require('html-webpack-plugin')

module.exports = {
    entry: './src/front/main.tsx',
    output: {
        path: path.resolve(__dirname, './src/main/resources/static/'),
        filename: 'bundle.js'
    },

    // Enable sourcemaps for debugging webpack's output.
    devtool: "source-map",

    resolve: {
        extensions: ['.js', '.ts', '.tsx'],
        /*modules: [
            'node_modules'
        ]*/
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
    devServer: {
        inline: true,
        contentBase: './src/front/',
        port: 8100,
        proxy: {
            "/api": "http://localhost:8080",
            "/login": "http://localhost:8080",
            "/logout": "http://localhost:8080"
        }
    },

    module: {
        rules: [
           /* {
                enforce: 'pre',
                test: /\.tsx?$/,
                loader: 'tslint',
                exclude: /(node_modules)/,
            },*/
            {
                test: /\.tsx?$/,
                loaders: ['awesome-typescript-loader'],
                exclude: /(node_modules)/
            }
        ],
        loaders: [
            {
                test: /\.tsx?$/,
                loader: ['react-hot-loader', 'babel-loader','awesome-typescript-loader']
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loaders: ['react-hot-loader', 'babel-loader']
            },
            {
                test: /\.(jpg|png)$/,
                loader: 'url-loader',
                options: {
                    limit: 25000,
                },
            },
            /*{
             test: /\.(jpg|png)$/,
             loader: 'file-loader',
             options: {
             outputPath: './images/[name].[ext]',
             },
             },*/
            {
                test: /\.scss$/,
                loaders: ['style-loader', 'css-loader', 'sass-loader']
            }
        ]
    },

    // When importing a module whose path matches one of the following, just
    // assume a corresponding global variable exists and use that instead.
    // This is important because it allows us to avoid bundling all of our
    // dependencies, which allows browsers to cache those libraries between builds.
    /*externals: {
        "react": "React",
        "react-dom": "ReactDOM"
    }*/
}