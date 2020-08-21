using Grpc.Core;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GrpcServer.Services
{
    public class ProductService : Product.ProductBase
    {

        private readonly ILogger<ProductService> _logger;

        public ProductService(ILogger<ProductService> logger)
        {
            _logger = logger;
        }


        public override Task<ProductModel> GetUserWelcome(ProductLookupModel request, ServerCallContext context)
        {
            ProductModel output = new ProductModel();

            if (request.ProductId == 1)
            {
                output.UserName = "Bren";
                output.UserWelcome = "Welcome";
            }
            else if (request.ProductId == 2)
            {
                output.UserName = "Matt";
                output.UserWelcome = "Welcome";
            }
            else
            {
                output.UserName = "John";
                output.UserWelcome = "Welcome";

            }

            return Task.FromResult(output);
        }

        public override async Task GetProductList(
            ProductListRequest request,
            IServerStreamWriter<ProductModel> responseStream,
            ServerCallContext context)
        {
            List<ProductModel> products = new List<ProductModel>
            {
                new ProductModel
                {

                ProductName = "pen",
                ProductType = "bic",
                ProductDesc = "blue pen for writing",
                Price = 5
            },

            new ProductModel
            {
                ProductName = "paper",
                ProductType = "oxford",
                ProductDesc = "a4 notepad for taking notes",
                Price = 4
            },
             new ProductModel
             {
                ProductName = "eraser",
                ProductType = "HB",
                ProductDesc = "Eraser for removing pencil markings",
                Price = 3
            },

        };

            foreach (var prod in products)
            {
                await responseStream.WriteAsync(prod);
            }
        }



    }
}
