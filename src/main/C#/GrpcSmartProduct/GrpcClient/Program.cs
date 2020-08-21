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

            var channel = GrpcChannel.ForAddress("https://localhost:5001");
            var productClient = new Product.ProductClient(channel);

            var clientRequested = new ProductLookupModel { ProductId = 1 };

            var product = await productClient.GetUserWelcomeAsync(clientRequested);

            Console.WriteLine($"{ product.UserWelcome} {product.UserName} ");
            Console.WriteLine();
            Console.WriteLine();

            using (var call = productClient.GetProductList(new ProductListRequest()))
            {
                while (await call.ResponseStream.MoveNext())
                {
                    var currentProduct = call.ResponseStream.Current;

                    Console.WriteLine("New Product List");
                    Console.WriteLine();
                    Console.WriteLine($" Product Name:{ currentProduct.ProductName} Product Type: { currentProduct.ProductType} Product Description: { currentProduct.ProductDesc} Price: { currentProduct.Price} ");

              
                    Console.WriteLine();


                }
            }


                Console.ReadLine();
        }
    }
}