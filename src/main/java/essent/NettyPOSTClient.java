package essent;

import org.apache.http.client.methods.HttpPost;

public class NettyPOSTClient {

    public void sendPOST(String address, byte[] data ){
        private void sendHttpPost(String input, ChannelHandlerContext ctx) {
            try {
                String url = "http://localhost";
                URI uri = new URI(url);
                Bootstrap b = new Bootstrap();
                b.group(new NioEventLoopGroup())
                        .channel(NioServerSocketChannel.class)
                        .handler(new PostRequestHandler())
                        .option(ChannelOption.AUTO_READ, false);
                Channel f = b.connect("REMOTE_HOST", 8888).sync().channel();
                HttpRequest postReq = new DefaultHttpRequest(HttpVersion.HTTP_1_1,
                        HttpMethod.POST, uri.getRawPath());
                postReq.headers().set(HttpHeaders.Names.HOST, "localhost");
                postReq.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.CLOSE);
                postReq.headers().set(HttpHeaders.Names.CONTENT_TYPE,"application/x-www-form-urlencoded");
                f.writeAndFlush(postReq);

                // Wait for the server to close the connection.
                f.closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    };
}
