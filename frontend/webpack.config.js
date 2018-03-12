const webpack = require('webpack'); //to access built-in plugins
const path = require('path');

module.exports = {
	entry: './src/index.js',
	devtool: 'eval-source-map',
	output: {
		filename: 'bundle.js',
	},
	module: {
		rules: [
			{
				test: /\.json$/,
				loader: 'json'
			},
			{
				test: /\.js$/,
				exclude: /node_modules/,
				loader: 'babel-loader',
				query: {presets: ['env','react'],'plugins': ['transform-object-rest-spread','transform-class-properties']}
			},
			{
				test: /\.css$/,
				use: [
					'style-loader',
					'css-loader'
				]
			},
			{
				test: /\.(png|svg|jpg|gif)$/,
				use: [
					'file-loader'
				]
			},
			{
				test: /\.(woff|woff2|eot|ttf|otf)$/,
				use: [
					'file-loader'
				]
			}
		]
	},
	plugins:[new webpack.ProvidePlugin({
		React: 'react',
		ReactDOM: 'react-dom'
	})],

	devServer:{
		port:3000
	}
};