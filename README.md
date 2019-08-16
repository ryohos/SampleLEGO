Sample LEGO
===============

### 前提

本マニュアルはWindowsユーザーを前提とします。
Macの場合は下記サイトをご確認ください。

### 環境構築

#### JDKのインストール

JDKの最新版をダウンロードしてインストールしてください。

* https://www.java.com/ja/


#### leJOS EV3のインストール

下記サイトからleJOS(**0.9.1-beta**)をダウンロードしてインストールしてください。

* https://sourceforge.net/projects/ev3.lejos.p/files/

*インストール時に全部にチェックをつけるとサンプルが取得可能です。*

#### Eclipseのインストール

下記サイトからEclipse(**Java FullEdition**)をダウンロードしてインストールしてください。

* http://mergedoc.osdn.jp/

*ダウンロードには時間が掛かるので気長にお待ちください。*

#### 実行確認（インテリジェントブロックへのプログラム転送）

*本サンプルを動かす前にインテリジェントブロックを近づけておいてください*
*他の方との同時使用はできません*

本サイトのソースコードをダウンロードし、Eclipseで起動してください。
HelloWorldのコメントが有効なことを確認します。
プロジェクトを選択した後、コンテキストメニューから「実行 ＞ LeJOS EV3 Program」を選択してください。

インテリジェントブロックにHelloWorldと出力されれば成功です。

尚、HelloWorldの文字は、HalloWorld.java の LCD.drawString で指定されている文字になります。
文字列を変更して文字列が変わるか試してみて下さい。

#### 実行確認（インテリジェントブロックからセンサーデータ取得）

*本サンプルを動かす前にインテリジェントブロックを近づけておいてください*
*他の方との同時使用はできません*

インテリジェントブロックの各ポートには下記のセンサーを接続してください。

* ポート1：タッチセンサー
* ポート２：超音波センサー
* ポート３：カラーセンサー
* ポート４：ジャイロセンサー

本サイトのソースコードをダウンロードし、Eclipseで起動してください。
HelloWorldのコメントアウトし、RemoteEv3Sensorを有効にしてください。
プロジェクトを選択した後、コンテキストメニューから「実行 ＞ Javaアプリケーション」を選択してください。

*上手くデータが取得できない場合は接続にミスしている可能性があります。*
*接続にミスするとポートが異常になりインテリジェントブロックの再起動が必要になります。*


#### 実行確認（インテリジェントブロックのモーターを制御）

*本サンプルを動かす前にインテリジェントブロックを近づけておいてください*
*他の方との同時使用はできません*

インテリジェントブロックの各ポートには下記のセンサーを接続してください。

* ポートA：Lモーター（インタラクティブサーボモーターL）
* ポートB：Mモーター（インタラクティブサーボモーターM）

本サイトのソースコードをダウンロードし、Eclipseで起動してください。
HelloWorldのコメントアウトし、RemoteEv3Sensorを有効にしてください。
プロジェクトを選択した後、コンテキストメニューから「実行 ＞ Javaアプリケーション」を選択してください。

*上手く動作しない場合は接続にミスしている可能性があります。*
*接続にミスするとポートが異常になりインテリジェントブロックの再起動が必要になります。*

#### 実行確認（イベントのハンドリング）

*本サンプルを動かす前にインテリジェントブロックを近づけておいてください*
*他の方との同時使用はできません*


#### ここまででできたこと

* LEGOにプログラムを送り込んで実行する
* リモートでLEGOのセンサー値を取得する
* リモートでLEGOを制御する

これらのできることを組み合わせると色々とできそうですね。
是非、LEGOを使ったTinkeringを楽しんでください。


### 参考文献

* http://qiita.com/murotani/items/e14c4b05b781ecf893d3
* http://www.legoedu.jp/ev3/pdf/ev3_user_guide.pdf

