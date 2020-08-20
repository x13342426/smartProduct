using Grpc.Core;
using Grpc.Net.Client;
using GrpcServer;
using System;
using System.Threading.Tasks;

namespace GrpcClient
{
    class Program
    {
        static async Task Main(string[] args)
        {
          //  var input = new HelloRequest { Name = "Bren" };
          //  var channel = GrpcChannel.ForAddress("https://localhost:5001");
          //  var client = new Greeter.GreeterClient(channel);


          //  var reply = await client.SayHelloAsync(input);

          //  Console.WriteLine(reply.Message);

            var channel = GrpcChannel.ForAddress("https://localhost:5001");
            var productClient = new Product.ProductClient(channel);

            var clientRequested = new ProductLookupModel { ProductId = 1 };

            var product = await productClient.GetProductInfoAsync(clientRequested);

            Console.WriteLine($"{ product.ProductName} { product.ProductType} { product.ProductDesc}");

            using (var call = productClient.GetProductList(new ProductListRequest()))
            {
                while (await call.ResponseStream.MoveNext())
                {
                    var currentProduct = call.ResponseStream.Current;

                    Console.WriteLine($" Product Name:{ currentProduct.ProductName} Product Type: { currentProduct.ProductType} Product Description: { currentProduct.ProductDesc} Price: { currentProduct.Price} ");

                    Console.WriteLine();
                    Console.WriteLine("New Product List");
                    Console.WriteLine();


                }
            }


                Console.ReadLine();
        }
    }
}